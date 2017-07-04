package br.edu.utfpr.md.umacolher.Cenas;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import br.edu.utfpr.md.umacolher.Sprites.MenuButtons;
import br.edu.utfpr.md.umacolher.Sprites.ScreenBackground;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.config.DeviceSettings;

/**
 * Created by victor on 20/06/17.
 */

public class TitleScreen extends CCLayer {

    private ScreenBackground background;

    public TitleScreen() {
        this.background = new ScreenBackground("inicial.png");
        this.background.setPosition(
                DeviceSettings.screenResolution(CGPoint.ccp(
                        CCDirector.sharedDirector().winSize().width / 2.0f,
                        CCDirector.sharedDirector().winSize().height / 2.0f
                )));

        this.addChild(this.background);

        MenuButtons menuLayer = new MenuButtons();
        this.addChild(menuLayer);
    }

    public CCScene scene() {
        CCScene scene = CCScene.node();
        scene.addChild(this);
        return scene;
    }


}
