package Lib.Model.RenderingGameLoop.GameImp;

public class RendererSpy extends RendererDummy {

    private boolean didRender = false;

    public boolean hasRendered() {
        return didRender;
    }

    public void render() {
        didRender = true;
    }
}
