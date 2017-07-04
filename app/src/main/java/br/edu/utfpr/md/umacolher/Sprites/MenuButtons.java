package br.edu.utfpr.md.umacolher.Sprites;



import org.cocos2d.layers.CCLayer;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import br.edu.utfpr.md.umacolher.Cenas.GameScene;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.config.DeviceSettings;
import br.edu.utfpr.md.umacolher.interfaces.ButtonDelegate;
import br.edu.utfpr.md.umacolher.object.Button;

/**
 * Created by victor on 20/06/17.
 */

public class MenuButtons extends CCLayer implements ButtonDelegate {

    private Button playButton;



    public MenuButtons() {
        this.setIsTouchEnabled(true);
        this.playButton = new Button(Assets.PLAY);


        // coloca botões na posição correta
        setButtonspPosition();
        addChild(playButton);

        this.playButton.setDelegate(this);


    }

    private void setButtonspPosition() {
        // Buttons Positions
        playButton.setPosition(DeviceSettings.screenResolution(CGPoint.ccp(960, 275)));

    }

    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(this.playButton)) {
            CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, GameScene.createGame()));
        }

    }

}
