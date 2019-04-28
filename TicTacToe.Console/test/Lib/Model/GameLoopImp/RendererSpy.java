package Lib.Model.GameLoopImp;

public class RendererSpy implements Renderer {

    private boolean didRender = false;
    private int timesRendered = 0;

    public boolean hasRendered() {
        return didRender;
    }

    public void render() {
        didRender = true;
        timesRendered++;
    }

    public int getTimesRendered() {
        return timesRendered;
    }
}
