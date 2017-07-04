package br.edu.utfpr.md.umacolher.engines;

import org.cocos2d.layers.CCLayer;

import br.edu.utfpr.md.umacolher.Sprites.Inimigo;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.interfaces.InimigoDelegate;

/**
 * Created by victor on 24/06/17.
 */

public class InimigoEngine extends CCLayer {

    private InimigoDelegate delegate;
    boolean valor = true;
    public InimigoEngine() {
        this.schedule("playerEngine");
    }

    public void playerEngine(float dt) {
            this.getDelegate().createInimigo();
    }

    public void setDelegate(InimigoDelegate delegate) {
        this.delegate = delegate;
    }

    public InimigoDelegate getDelegate() {
        return delegate;
    }


}
