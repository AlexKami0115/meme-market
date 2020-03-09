import { Patron } from './patron';
import { OwnedCard } from './owned-card';
import { TradeStatus } from './trade-status';

export class Trade {
    id: number;
    patronOne: Patron;
    patronTwo: Patron;
    cardsToBeTraded: OwnedCard[];
    tradeStatus: TradeStatus;
}
