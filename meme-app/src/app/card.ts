import { Tag } from './tag';
import { Rarity } from './rarity';

export class Card {
    id: number;
    image: string;
    cardText: string;
    memeText: string;
    tag: Tag;
    rarity: Rarity;
}
