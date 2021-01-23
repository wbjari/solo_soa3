package domain;

import interfaces.ISCMAdapter;

public class SCM {

    private ISCMAdapter scmAdapter;

    public ISCMAdapter getScmAdapter() {
        return scmAdapter;
    }
    public void setScmAdapter(ISCMAdapter scmAdapter) {
        this.scmAdapter = scmAdapter;
    }
}
