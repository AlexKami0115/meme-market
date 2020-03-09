import { Card } from './card';
import { Patron } from './patron';

export class OwnedCard {
    id: number;
    card: Card;
    patron: Patron;
    showcase: number;
}
