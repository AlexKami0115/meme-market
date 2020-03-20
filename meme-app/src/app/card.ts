import { Tag } from './tag';
import { Rarity } from './rarity';
import { Comment } from './comment';

export class Card {
    static find(arg0: (hero: any) => boolean): any {
      throw new Error("Method not implemented.");
    }
    id: number;
    image: string;
    cardText: string;
    memeText: string;
    comment: Comment[];
    tag: Tag[];
    rarity: Rarity;
}
