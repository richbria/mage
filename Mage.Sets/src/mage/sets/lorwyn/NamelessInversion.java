/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.lorwyn;

import java.util.UUID;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.abilities.effects.common.continuous.LoseAllCreatureTypesTargetEffect;
import mage.abilities.keyword.ChangelingAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author emerald000
 */
public class NamelessInversion extends CardImpl {

    public NamelessInversion(UUID ownerId) {
        super(ownerId, 128, "Nameless Inversion", Rarity.COMMON, new CardType[]{CardType.TRIBAL, CardType.INSTANT}, "{1}{B}");
        this.expansionSetCode = "LRW";
        this.subtype.add("Shapeshifter");

        this.color.setBlack(true);

        // Changeling
        this.addAbility(ChangelingAbility.getInstance());
        
        // Target creature gets +3/-3 and loses all creature types until end of turn.
        Effect effect = new BoostTargetEffect(3, -3, Duration.EndOfTurn);
        effect.setText("Target creature gets +3/-3");
        this.getSpellAbility().addEffect(effect);
        effect = new LoseAllCreatureTypesTargetEffect(Duration.EndOfTurn);
        effect.setText("and loses all creature types until end of turn");
        this.getSpellAbility().addEffect(effect);
        this.getSpellAbility().addTarget(new TargetCreaturePermanent());
    }

    public NamelessInversion(final NamelessInversion card) {
        super(card);
    }

    @Override
    public NamelessInversion copy() {
        return new NamelessInversion(this);
    }
}