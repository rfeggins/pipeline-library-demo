

/* Reference links
 *
 * https://jenkins.io/doc/pipeline/steps/
 *
 * JIRA Pipeline Steps Plugin Reference links
 * https://jenkins.io/doc/pipeline/steps/jira-steps/
 * https://github.com/jenkinsci/jira-steps-plugin
 *
 */
 
 
 def call (Map myParams) {
 jiraAddComment site: 'LOCAL', idOrKey: 'TEST-1', comment: 'test comment'

 
 }
 
