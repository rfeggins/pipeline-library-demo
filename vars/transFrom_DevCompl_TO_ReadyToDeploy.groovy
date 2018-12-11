

/* Reference links
 *
 * https://jenkins.io/doc/pipeline/steps/
 *
 * JIRA Pipeline Steps Plugin Reference links
 * https://jenkins.io/doc/pipeline/steps/jira-steps/
 * https://github.com/jenkinsci/jira-steps-plugin
 *
 */
 
 
 def call (Map config) {
  
  // config.pull_request_merged
  // config.ddtl_ID
  // config.jiraSite 
  // define local variables
  def transitionInput
  def trans_issue
  
  
  echo "##############################################################################"
  echo "executing shared lib call to transFrom DevComplete to ReadyForQA
  echo "##############################################################################"
  
  transitionInput = [ transition: [ id: config.pull_request_merged ] ]
                      
  try {
        trans_issue = jiraTransitionIssue idOrKey: ddtl_ID , input: transitionInput, site: jiraSite
        echo "transiton response " + trans_issue.data.toString()

  } catch (err) {
        error "Exception"
        jiraAddComment idOrKey: ddtl_ID , site: jiraSite, comment: "${BUILD_URL} ERROR WHILE RELEASING ${error}"
        currentBuild.result = 'FAILURE'
  } // END Catch

} // END shared library
 
