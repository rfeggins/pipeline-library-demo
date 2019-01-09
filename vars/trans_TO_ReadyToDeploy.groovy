
def call (
   jiraSiteName,
   jiraID,
   newJiraState
   ) {

  // config.pull_request_merged
  // config.ddtl_ID
  // config.jiraSite
  // define local variables
  def transitionInput
  def trans_issue


  echo "##############################################################################"
  echo "executing shared lib call to transFrom DevComplete to ReadyForQA"
  echo "##############################################################################"


  Integer pull_request_merged = 101
  def transitionInput = [ transition: [ id: pull_request_merged ] ]

  try {
       echo "jiraID   ${jiraID}"
       echo "jiraSiteName  ${jiraSiteName}"
       echo "newJiraState  ${newJiraState}"

        trans_issue = jiraTransitionIssue idOrKey: jiraID , input: transitionInput, site: jiraSiteName

        echo "transiton response " + trans_issue.data.toString()
        echo trans_issue

  } catch (err) {
        error "Script Error transitioning to ReadyToDeploy"

  } // END Catch

} // END shared library
