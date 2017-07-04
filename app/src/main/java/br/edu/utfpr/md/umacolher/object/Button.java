package br.edu.utfpr.md.umacolher.object;

import android.view.MotionEvent;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import br.edu.utfpr.md.umacolher.interfaces.ButtonDelegate;

/**
 * Created by victor on 20/06/17.
 */

public class Button extends CCLayer {

    private CCSprite buttonImage;
    private ButtonDelegate delegate;

    public Button(String buttonImage) {
        this.setIsTouchEnabled(true);
        this.buttonImage = CCSprite.sprite(buttonImage);
        addChild(this.buttonImage);
    }

    public void setDelegate(ButtonDelegate sender) {
        this.delegate = sender;
    }

    @Override
    protected void registerWithTouchDispatcher() {
        CCTouchDispatcher.sharedDispatcher().addTargetedDelegate(this, 0, false);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {
        CGPoint touchLocation = CGPoint.make(event.getX(), event.getY());
        touchLocation = CCDirector.sharedDirector().convertToGL(touchLocation);
        touchLocation = this.convertToNodeSpace(touchLocation);

        // Verifica toque no botão
        if (CGRect.containsPoint(
                this.buttonImage.getBoundingBox(), touchLocation)) {
            delegate.buttonClicked(this);
        }
        return true;
    }

}
