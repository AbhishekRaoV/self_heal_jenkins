import os

# Define the path to the Jenkins job build log file
log_file_path = "/var/lib/jenkins/jobs/sample/builds/lastStableBuild/log"

# Check if the log file exists
if not os.path.exists(log_file_path):
    print("Log not found at", log_file_path)
else:
    print("Log found at", log_file_path)
