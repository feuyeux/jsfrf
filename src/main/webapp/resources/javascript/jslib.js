var spec_version = jsf.specversion;
var impl_version = jsf.implversion;
var form = document.getElementById('libForm');
var view_state= jsf.getViewState(form);
var stage = jsf.getProjectStage();

var output="[jsf.specversion]:"+spec_version+"\n"
+"[jsf.implversion]:"+impl_version+"\n"
+"[ViewState]:"+view_state+"\n"
+"[ProjectStage]:"+stage+"\n";

alert(output);