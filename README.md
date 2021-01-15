
## Instructions
	
	On the terminal run the program with one argument in a single line. 
	input -> gousto.py path/to/file dayX(YYYY-MM-DD) dayX-1(YYYY-MM-DD)
	Example bellow.
	Example -> python gousto.py events "2014-09-29" "2014-09-28" 


## Feedback Solution

	I create this ETL process to report the following metrics:
		● number of active users
		● number of inactive users 
		● number of churned users 
		● number of reactivated users 

	The option part (number of sessions) I would requere more information to understand the question.
	At Artlogic, I run my ETL when I need it. Unfortunately, I don't know how to how to schedule it 
	or use the Redshift. I can guarantee that if Gousto gives me this opportunity, I will learn fast 
	and be productive.

## Scenario

	At Gousto we use the open source event analytics platform Snowplow. It enables us to
	collect very granular data about our customers from various sources as a unified
	customer view. We use this data to analyse customers' behaviour and to train our
	machine learning algorithms for personalisation and to predict the right actions to
	engage customers as much as possible.

	For daily reporting purposes we are interested in the following metrics:
		● number of active users (users who visited our website on day X and day X-1)
		● number of inactive users (users who didn't visit our website on day X and neither 
			on day X-1)
		● number of churned users (users who visited our website on day X-1, but didn't visit
			on day X)
		● number of reactivated users (users who visited our website on day X, but didn't 
			visit on day X-1)
		● [optional] number of sessions (we define session as a set of events per user with 
			gaps no more than 30 minutes)

## Your objectives

	The data to be used for this test is available at
	https://s3-eu-west-1.amazonaws.com/gousto-hiring-test/data-engineer/events.gz. It
	contains about 1.5 million events and for this test we included page-views only.
	Each event (record) has the following attributes: event_id, timestamp, user_fingerprint,
	domain_userid, network_userid, page.

	## Requirements

		● Create ETL process(es) to prepare metrics listed in scenario.
		● Preferred programming language is Python, but please feel free to use any other 
			programming language if you don't feel comfortable with Python.
		● As we store events in Redshift, we prefer you to use SQL to aggregate data, but 
			feel free to use any other technology, e.g. Hadoop, Pig, Spark etc.
		● Suppose that ETL process(es) need(s) to be run on a daily basis, but feel free to 
			run it on a more frequent basis if you prefer.
		● Suggest at what time ETL process(es) should be run.
	
	## Nice-to-haves
		● A way to schedule ETL process(es) - feel free to use any tool or framework.
		● ETL process(es) should be deployable, ideally in AWS environment.
		● We'd like to be notified if ETL process(es) failed for some reason.
		Not expected
		● We are not expecting any reports / dashboards.
		Tips
		● Are ETL processes configurable and reusable?
		● What happens if ETL process(es) fail(s) for some reason? Can it be re-run and will
		still get correct metrics?
	
	## Time to get started!
	
	This test is intended to give you an opportunity to demonstrate how you would tackle this
	problem. You are free to take your own approach to achieve the objective!
	Please send back a zip file containing all of the assets required for us to run and test the
	ETL process. Please also include a README explaining your solution along with any
	relevant instructions to get the ETL process set up.
	Good luck!

#### Thanks for this opportunity, I am looking forward to being part of the Gousto TEAM!