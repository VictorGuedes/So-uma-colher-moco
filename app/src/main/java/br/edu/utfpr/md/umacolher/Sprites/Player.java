package br.edu.utfpr.md.umacolher.Sprites;

import org.cocos2d.actions.base.CCAction;
import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCRepeat;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import java.util.ArrayList;

import br.edu.utfpr.md.umacolher.config.Assets;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenResolution;

/**
 * Created by victor on 24/06/17.
 */

public class Player extends CCSprite {

    float positionX = 10;
    float positionY = 200;

    private ArrayList<CCSpriteFrame> andando = new ArrayList<CCSpriteFrame>();
    private CGRect c = new CGRect();
    private CGPoint posicao = new CGPoint();
    private CCAnimation animacaoGlobal;
    private CCAction acaoAnddar;

    public Player(){
        super(Assets.andarPlayer.get(0));
        c.set(0, 0, 310, 320);
        posicao.set(positionX, positionY);
        criaAnimacao();

    }

    public void start(){
        this.schedule("update");
    }

    public void criaAnimacao(){
        for (int i = 0; i < Assets.andarPlayer.size(); i++){
            CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(Assets.andarPlayer.get(i));
            CCSpriteFrame f = CCSpriteFrame.frame(texture, c, posicao);
            this.andando.add(f);
        }
        CCAnimation animacao = CCAnimation.animation("Animacao", 0.2f, this.andando);
        animacaoGlobal = animacao;
        acaoAnddar = CCRepeatForever.action(CCAnimate.action(animacaoGlobal));
        this.runAction(acaoAnddar);
    }

    public void criarAnimacaoPegarColher(){
        andando.clear();

        for (int i = 0; i < Assets.playerPegaComida.size(); i++){
            CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(Assets.playerPegaComida.get(i));
            CCSpriteFrame f = CCSpriteFrame.frame(texture, c, posicao);
            this.andando.add(f);
        }
        CCAnimation animacao = CCAnimation.animation("AnimacaoColher", 0.2f, this.andando);
        animacaoGlobal = animacao;
        acaoAnddar = CCRepeat.action(CCAnimate.action(animacaoGlobal), 1);
    }

    public void pegaComida(){
        this.runAction(acaoAnddar);
    }


    public void update(float dt) throws InterruptedException {
        if(positionX < 1210){
            positionX += 5;
            this.setPosition(screenResolution(CGPoint.ccp(positionX, positionY)));
        }else {
            this.stopAction(acaoAnddar);
            this.setTexture(CCTextureCache.sharedTextureCache().addImage(Assets.playerPegaComida.get(0)));

            this.criarAnimacaoPegarColher();
            acaoAnddar.setTag(0);
            this.unschedule("update");
        }
    }


    public CCAction getAcaoAnddar() {
        return acaoAnddar;
    }


}
