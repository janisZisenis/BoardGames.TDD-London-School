package Lib.GameLoopImp;

public class RendererSpy implements Renderer {

    private int timesRendered = 0;

    public void render() {
        timesRendered++;
    }

    public int getTimesRendered() {
        return timesRendered;
    }
}
