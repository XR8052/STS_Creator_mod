package theCreator.cards;


import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;

	public class MagicHat extends CustomCard {

		public static final String ID = "MagicHat";
		private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	    public static final String NAME = cardStrings.NAME;
	    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	    public static final String IMG_PATH = "img/nay.png";
	    public static final int COST = 2;

		
		
		
		public MagicHat() {
			super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
					AbstractCard.CardType.SKILL, AbstractCard.CardColor.COLORLESS, 
					AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);

			}

		@Override
		public AbstractCard makeCopy() {
		
			return new MagicHat();
		}

		@Override
		public void upgrade() {
			// TODO Auto-generated method stub
			if (!this.upgraded){
				this.upgradeName();
				this.upgradeBaseCost(0);

			}
		}

		@Override
		public void use(AbstractPlayer p, AbstractMonster m) {
			// At most 5 times
			AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat().makeCopy();
			AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
			int t = AbstractDungeon.cardRandomRng.random(4);
			if (t > 0){
			for (int i = 0 ; i < t ; i ++){
				 c = AbstractDungeon.returnTrulyRandomCardInCombat().makeCopy();
				AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
				}
			}
		}
	}
