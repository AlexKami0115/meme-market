import { OwnedCard } from './owned-card';
import { User } from './user';

export class Patron {
    id: number;
    stonks: number;
    ownedCards: OwnedCard[];
}
