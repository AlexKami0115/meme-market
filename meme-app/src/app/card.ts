import { TagContentType } from '@angular/compiler';

export class Card {
    id: number;
    image: string;
    cardText: string;
    memeText: string;
    tag: Tag;
    rarity: Rarity;
}
