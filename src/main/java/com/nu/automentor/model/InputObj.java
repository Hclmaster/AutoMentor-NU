package com.nu.automentor.model;

import java.util.List;

public class InputObj {
    private String inputMessage;
    private String sourceCode;
    private String computerOutput;
    private String expectedOutput;
    private String source;
    private String stuckInput;
    private List<String> confusionInputs;

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getComputerOutput() {
        return computerOutput;
    }

    public void setComputerOutput(String computerOutput) {
        this.computerOutput = computerOutput;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public List<String> getConfusionInputs() {
        return confusionInputs;
    }

    public void setConfusionInputs(List<String> confusionInputs) {
        this.confusionInputs = confusionInputs;
    }

    public String getStuckInput() {
        return stuckInput;
    }

    public void setStuckInput(String stuckInput) {
        this.stuckInput = stuckInput;
    }
}
