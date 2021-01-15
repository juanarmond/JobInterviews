#!/usr/bin/python
# coding=utf-8

import sys

# ● Create ETL process(es) to prepare metrics listed in scenario.
# ● Preferred programming language is Python, but please feel free to use any other
# programming language if you don't feel comfortable with Python.
# ● As we store events in Redshift, we prefer you to use SQL to aggregate data, but
# feel free to use any other technology, e.g. Hadoop, Pig, Spark etc.
# ● Suppose that ETL process(es) need(s) to be run on a daily basis, but feel free to run
# it on a more frequent basis if you prefer.
# ● Suggest at what time ETL process(es) should be run.
# Nice-to-haves
# ● A way to schedule ETL process(es) - feel free to use any tool or framework.
# ● ETL process(es) should be deployable, ideally in AWS environment.
# ● We'd like to be notified if ETL process(es) failed for some reason.

class ClientsMetrics():
	
	dayX=''
	dayY=''
	
	def __init__(self, file, dayX, dayY):
		self.dayX = dayX
		self.dayY = dayY
		active_users = self.active_users(file)
		users_by_day = self.users_day(active_users, dayX, dayY)
		active = self.number_of_active_users(users_by_day)
		inactive = self.number_of_inactive_users(active_users, active)
		churned = self.number_of_churned_users(users_by_day)
		reactivated = self.number_of_reactivated_users(users_by_day)
		# sessions = self.number_of_sessions(active_users)

	def active_users(self, file):
		# client_info = []
		active_users = {}
		f = open(file, "r")
		for line in f:
			result = line.replace('"','').split(',')
			if not result[2]:
				result[2] = 'unknown'
			if result[2] not in active_users:
				active_users[result[2]]= []
			active_users[result[2]].append({"event_id":result[0], "timestamp":result[1], "user_fingerprint":result[2],"domain_userid":result[3], "network_userid":result[4], "page":result[5]})
		print('Total of active users',len(active_users))
		return active_users

	def users_day(self, active_users, dayX, dayY):
		users_by_day={'dayX':[], 'dayY':[]}
		for user, user_info in active_users.items():
			for info in user_info:
				if dayX in info["timestamp"] and user not in users_by_day['dayX']:
					users_by_day['dayX'].append(user)
				if dayY in info["timestamp"] and user not in users_by_day['dayY']:
					users_by_day['dayY'].append(user)
		# print(len(users_by_day['dayX']), len(users_by_day['dayY'])) 
		return users_by_day

	# number of active users (users who visited our website on day X and day X-1)
	def number_of_active_users(self,users_by_day):
		count = 0
		for user in users_by_day['dayX']:
		    if user in users_by_day['dayY']:
		        count+=1
		result = len(users_by_day['dayX'])+len(users_by_day['dayY'])-count
		print(result)
		result = len(set(users_by_day['dayX']+users_by_day['dayY']))
		print('Number of active users',result)
		return result
	
	# number of inactive users (users who didn't visit our website on day X and neither on day X-1)
	def number_of_inactive_users(self, active_users, active):
		result = len(active_users)-active
		print('Number of inactive users', result)
		return result
	
	# number of churned users (users who visited our website on day X-1, but didn't visit on day X)
	def number_of_churned_users(self, users_by_day):
		result = len(set(users_by_day['dayY'])-set(users_by_day['dayX']))
		print('Number of churned users', result)
		return result

	# number of reactivated users (users who visited our website on day X, but didn't visit on day X-1)
	def number_of_reactivated_users(self, users_by_day):
		result = len(set(users_by_day['dayX'])-set(users_by_day['dayY']))
		print('Number of reactivated users', result)
		return result

	# [optional] number of sessions (we define session as a set of events per user with gaps no more than 30 minutes)
	# I need more information about this???
	# def number_of_sessions(self, active_users):

def main(argv):
	
	# print sys.argv[0] # prints python_script.py
	inputfile =  sys.argv[1] # prints inputfile
	dayX =  sys.argv[2] # prints dayX
	dayX1 =  sys.argv[3] # prints dayX-1
	ClientsMetrics(inputfile, dayX, dayX1)

if __name__ == '__main__':
    main(sys.argv[1:])


# ClientsMetrics("events", "2014-09-29", "2014-09-28")


