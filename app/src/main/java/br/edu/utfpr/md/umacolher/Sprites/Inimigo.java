package br.edu.utfpr.md.umacolher.Sprites;

import org.cocos2d.actions.base.CCAction;
import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import java.util.ArrayList;

import br.edu.utfpr.md.umacolher.Cenas.FinalScreen;
import br.edu.utfpr.md.umacolher.Cenas.GameScene;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.interfaces.InimigoDelegate;
import br.edu.utfpr.md.umacolher.object.Score;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenResolution;

/**
 * Created by victor on 24/06/17.
 */

public class Inimigo extends CCSprite {

    private float positionX = -100;
    private float positionY = 200;

    private ArrayList<CCSpriteFrame> andando = new ArrayList<CCSpriteFrame>();
    private CGRect c = new CGRect();
    private CGPoint posicao = new CGPoint();
    private CCAnimation animacaoGlobal;
    private CCAction acaoAnddar;
    private InimigoDelegate delegate;


    public Inimigo(){
        super(Assets.andarInimigo.get(0));
    }

    public void criaAnimacao(){
        c.set(0, 0, 310, 320);
        posicao.set(positionX, positionY);

        for (int i = 0; i < Assets.andarInimigo.size(); i++){
            CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(Assets.andarInimigo.get(i));
            CCSpriteFrame f = CCSpriteFrame.frame(texture, c, posicao);
            this.andando.add(f);
        }
        CCAnimation animacao = CCAnimation.animation("Animacao", 0.2f, this.andando);
        animacaoGlobal = animacao;
        acaoAnddar = CCRepeatForever.action(CCAnimate.action(animacaoGlobal));
    }

    public void iniciaAnimacao(){
        this.runAction(acaoAnddar);
    }

    public void start(){
        this.schedule("update");
    }

    public void update(float dt) throws InterruptedException {
        if(positionX < 1060){
            positionX += 0.8;
            this.setPosition(screenResolution(CGPoint.ccp(positionX, positionY)));
        }else {
            this.stopAction(acaoAnddar);
            CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, FinalScreen.scene()));
            this.unschedule("update");
        }
    }


    public void setDelegate(InimigoDelegate delegate){
        this.delegate = delegate;
    }


}
