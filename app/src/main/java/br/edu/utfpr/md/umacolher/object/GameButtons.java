package br.edu.utfpr.md.umacolher.object;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;

import br.edu.utfpr.md.umacolher.Cenas.GameScene;
import br.edu.utfpr.md.umacolher.R;
import br.edu.utfpr.md.umacolher.Sprites.Player;
import br.edu.utfpr.md.umacolher.Sprites.Tia;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.interfaces.ButtonDelegate;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenResolution;
import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenWidth;

/**
 * Created by victor on 24/06/17.
 */

public class GameButtons extends CCLayer implements ButtonDelegate {


    private Button shootButton;
    private GameScene delegate;
    private Player player;
    private Score pontos;
    private Tia tia;

    public static GameButtons gameButtons() {
        return new GameButtons();
    }

    public GameButtons() {
        // Habilita o toque na tela
        this.setIsTouchEnabled(true);

        // Cria os botões
        this.shootButton = new Button(Assets.BUTTON);

        // Configura as delegações
        this.shootButton.setDelegate(this);
        setButtonspPosition();

        // Adiciona os botões na tela
        addChild(shootButton);
    }

    private void setButtonspPosition() {
        // Posição dos botões
        shootButton.setPosition(screenResolution(CGPoint.ccp(1740, 180)));
    }

    @Override
    public void buttonClicked(Button sender) {

        if (sender.equals(this.shootButton)) {
            if(player.getAcaoAnddar().getTag() == 0){
                SoundEngine.sharedEngine().playEffect(CCDirector.sharedDirector().getActivity(), R.raw.coin);
                player.pegaComida();
                pontos.increase();
                Assets.pontosTotal = pontos;

            }else{
                System.out.println("Andando");
            }

        }

    }



    public void setDelegate(GameScene gameScene, Player player, Score pontos, Tia tia) {
        this.delegate = gameScene;
        this.player = player;
        this.pontos = pontos;
        this.tia = tia;
    }

}
