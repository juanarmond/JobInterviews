# -*- coding: utf-8 -*-
import argparse
import json
import os

def split_file(input_file, output_dir, max_bytes, max_lines):
    count = 0
    count_lines = 1
    f = open(input_file, "r")
    text = f.read()
    file = ""
    for i, c in enumerate(text):
        file+=c
        if c == '\n':
            count_lines+=1
        if len(file)==max_bytes or count_lines==max_lines or i == len(text)-1:
            new_file = open('{}/{}{}.jsonl'.format(output_dir, 'large-data-part', count), 'w')
            lines = file.split('\n')
            for l, line in enumerate(lines):
                json_record = json.dumps(line)
                if l != len(lines)-1:
                    new_file.write(json_record + '\n')
                else:
                    new_file.write(json_record)
            count+=1
            file = ""
            count_lines = 1

    f.close() 

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('--input-file', type=str, required=True)
    parser.add_argument('--output-dir', type=str, required=True)
    parser.add_argument('--max-bytes', type=int, required=True)
    parser.add_argument('--max-lines', type=int, required=True)

    args = parser.parse_args()

    split_file(args.input_file, args.output_dir, args.max_bytes, args.max_lines)

    print(args.input_file)
    print(args.output_dir)
    print(args.max_bytes)
    print(args.max_lines)


if __name__ == '__main__':
    main()

