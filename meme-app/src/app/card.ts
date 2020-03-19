import { Tag } from './tag';
import { Rarity } from './rarity';

export class Card {
    static find(arg0: (hero: any) => boolean): any {
      throw new Error("Method not implemented.");
    }
    id: number;
    image: string;
    cardText: string;
    memeText: string;
    tag: Tag;
    rarity: Rarity;
}
