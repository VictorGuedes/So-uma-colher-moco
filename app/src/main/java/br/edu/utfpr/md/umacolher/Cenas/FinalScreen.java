package br.edu.utfpr.md.umacolher.Cenas;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.opengl.CCBitmapFontAtlas;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor3B;

import br.edu.utfpr.md.umacolher.R;
import br.edu.utfpr.md.umacolher.Sprites.ScreenBackground;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.interfaces.ButtonDelegate;
import br.edu.utfpr.md.umacolher.object.Button;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenHeight;
import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenResolution;
import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenWidth;

/**
 * Created by victor on 02/07/17.
 */

public class FinalScreen extends CCLayer implements ButtonDelegate {

    private ScreenBackground background;
    private Button beginButton;
    private CCBitmapFontAtlas text;
    private CCLabel texto;

    public FinalScreen() {
// background
        this.background = new ScreenBackground(Assets.GAMEOVER);
        this.background.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2.0f,
                        screenHeight() / 2.0f)));
        this.addChild(this.background);



// imagem
        this.setIsTouchEnabled(true);
        this.beginButton = new Button(Assets.PLAY);
        this.beginButton.setPosition(960, 215);
        this.beginButton.setDelegate(this);
        addChild(this.beginButton);

        this.texto = CCLabel.makeLabel(Integer.toString(Assets.pontosTotal.getPontos()), "8bit.ttf", 115);
        this.texto.setColor(ccColor3B.ccc3(252, 70, 44));
        this.texto.setPosition(960, 540);
        this.addChild(this.texto);
    }


    public static CCScene scene() {
        CCScene scene = CCScene.node();
        FinalScreen layer = new FinalScreen();
        scene.addChild(layer);
        return scene;
    }


    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(this.beginButton)) {
            SoundEngine.sharedEngine().pauseSound();
            CCScene scene = new TitleScreen().scene();
            CCDirector.sharedDirector().runWithScene(scene);
        }
    }
}
