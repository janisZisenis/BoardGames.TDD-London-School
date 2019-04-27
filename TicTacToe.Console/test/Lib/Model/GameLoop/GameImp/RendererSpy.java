package Lib.Model.GameLoop.GameImp;

public class RendererSpy implements Renderer {

    private boolean didRender = false;

    public boolean hasRendered() {
        return didRender;
    }

    public void render() {
        didRender = true;
    }
}
