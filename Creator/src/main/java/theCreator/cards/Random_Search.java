package theCreator.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.orbs.Plasma;
import com.megacrit.cardcrawl.vfx.RainbowCardEffect;

import basemod.abstracts.CustomCard;

	public class Random_Search extends CustomCard {

		public static final String ID = "Random Search";
		private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	    public static final String NAME = cardStrings.NAME;
	    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	    public static final String IMG_PATH = "img/nay.png";
	    public static final int COST = 3;

		
		
		
		public Random_Search() {
			super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
					AbstractCard.CardType.SKILL, AbstractCard.CardColor.COLORLESS, 
					AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
			// TODO Auto-generated constructor stub
			this.showEvokeValue = true;
			this.showEvokeOrbCount = 4;
			this.exhaust = false;
			
			}

		@Override
		public AbstractCard makeCopy() {
		
			return new Random_Search();
		}

		@Override
		public void upgrade() {
			// TODO Auto-generated method stub
			if (!this.upgraded){
				this.upgradeName();
				this.upgradeBaseCost(1);
				this.exhaust = true;
				this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
				initializeDescription();
			}
		}

		@Override
		public void use(AbstractPlayer p, AbstractMonster m) {
			AbstractDungeon.actionManager.addToBottom(new VFXAction(new RainbowCardEffect()));
			AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
			AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Dark()));
			AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Frost()));
			AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Plasma())); 
			
		}
	}
