import { Card } from './card';
import { Patron } from './patron';
import { Timestamp } from 'rxjs';

export class Comment {
    id: number;
    card: Card;
    patron: Patron;
    commentText: string;
    timeOfComment: Date;
}
