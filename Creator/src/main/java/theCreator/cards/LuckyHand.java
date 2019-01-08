package theCreator.cards;

import java.util.Date;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.random.Random;

import basemod.abstracts.CustomCard;

public class LuckyHand extends CustomCard {

	public static final String ID = "LuckyHand";
	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/nay.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 12;
    private static final int UPGRADE_PLUS_DMG = 6;
    private static final int VULNERABLE_AMT = 1;
    private static final int UPGRADE_PLUS_VULNERABLE = 1;

	
	
	
	public LuckyHand() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
				AbstractCard.CardType.ATTACK, AbstractCard.CardColor.COLORLESS, 
				AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
		// TODO Auto-generated constructor stub
		this.baseDamage = ATTACK_DMG;
		this.magicNumber = this.baseMagicNumber = 12;

		}

	@Override
	public AbstractCard makeCopy() {
	
		return new LuckyHand();
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		if (!this.upgraded){
			this.upgradeName();
			this.upgradeDamage(6);
			this.upgradeMagicNumber(6);
		}
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		Random rand = new Random();
		//LUCKY
		if (rand.randomBoolean( 0.5f)){
			AbstractDungeon.actionManager.addToBottom(
					new com.megacrit.cardcrawl.actions.common.DamageAction
					(m, new DamageInfo(p, this.damage, this.damageTypeForTurn),
							AbstractGameAction.AttackEffect.BLUNT_HEAVY)
					);
		}
		//NOPE
		else{
			AbstractDungeon.actionManager.addToBottom(
					new com.megacrit.cardcrawl.actions.common.DamageAction
					(m, new DamageInfo(p, 0, this.damageTypeForTurn),
							AbstractGameAction.AttackEffect.BLUNT_LIGHT)
					);
		}
	}

}
