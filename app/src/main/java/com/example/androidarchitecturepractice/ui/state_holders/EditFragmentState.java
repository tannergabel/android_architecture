package com.example.androidarchitecturepractice.ui.state_holders;

public class EditFragmentState
{
    private int targetColorId;

    public EditFragmentState(int targetColorId)
    {
        this.targetColorId = targetColorId;
    }

    public int getTargetColorId()
    {
        return targetColorId;
    }

    public void setTargetColorId(int targetColorId)
    {
        this.targetColorId = targetColorId;
    }
}
