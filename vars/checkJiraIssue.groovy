#!/usr/bin/env groovy

def call( ) {
  echo "Executing checkJiraIssue"
  echo "gitCommit" + myParams.gitCommit
  echo "GIT_COMMIT" + "${GIT_COMMIT}"

  def gitCommitMsg = sh(returnStdout: true, script:  'git log --oneline -1 ${GIT_COMMIT}')

  def jiraIDs = sh(returnStdout: true, script: 'git log --oneline -1 ${GIT_COMMIT} | grep -i -o ddtl-.... | tr -d "\n" ')

  echo "Jenkins pipeline shell output"
  echo "git commit message  " + gitCommitMsg
  echo "####" + jiraIDs + "####"
  ddtl_ID = jiraIDs

  // validate that ddtl number is found within Git gitCommitMsg message
  if (ddtl_ID == "") {
    echo "##########################"
    echo "Jira Process Error 101 - No DDTL Issue found in Git Commit Message\n for build  "
    echo "commit message::     " + gitCommitMsg
    echo "##########################"
    currentBuild.result = 'FAILURE'

  } else {
    echo "Following DDTL IDs retrieved from git commit message"
    echo ddtl_ID
  }
}
