package br.edu.utfpr.md.umacolher.Sprites;

import android.os.SystemClock;

import org.cocos2d.actions.base.CCAction;
import org.cocos2d.actions.base.CCFiniteTimeAction;
import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCRepeat;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.TimerTask;
import java.util.logging.Handler;

import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.config.Tempo;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenResolution;

/**
 * Created by victor on 03/07/17.
 */

public class Tia extends CCSprite {

    float posicaoX = 1580;
    float posicaoY = 580;

    private ArrayList<CCSpriteFrame> framesTia = new ArrayList<CCSpriteFrame>();
    private CGRect c = new CGRect();
    private CGPoint posicao = new CGPoint();
    private CCAnimation animacaoTia;
    private CCAction acaoTia;



    public Tia(){
        super(Assets.tiaAtenta.get(0));
        c.set(0, 0, 522, 358);
        posicao.set(posicaoX, posicaoY);
        criaAnimacaoAtenta();

    }

    public void criaAnimacaoAtenta(){
        for (int i = 0; i < Assets.tiaAtenta.size(); i++){
            CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(Assets.tiaAtenta.get(i));
            CCSpriteFrame f = CCSpriteFrame.frame(texture, c, posicao);
            this.framesTia.add(f);

        }
        CCAnimation animacao = CCAnimation.animation("AnimacaoTiaAtenta", 1.5f, this.framesTia);
        animacaoTia = animacao;
        acaoTia = CCRepeatForever.action(CCAnimate.action(animacaoTia));
        acaoTia.setTag(1);
        this.runAction(acaoTia);

    }


    public CCAction getAcaoTia() {
        return acaoTia;
    }

}
