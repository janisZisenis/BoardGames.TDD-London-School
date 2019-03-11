package com.company.Core.InputRules.AlertingRule;

public class AlerterSpy implements Alerter {
    private boolean alerted = false;

    public void alert() {
        this.alerted = true;
    }

    public boolean hasAlerted() {
        return alerted;
    }
}
