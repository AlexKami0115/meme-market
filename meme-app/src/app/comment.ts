import { Card } from './card';
import { Patron } from './patron';
import { Timestamp } from 'rxjs';

export class Comment {
    id: number;
    cardId: number;
    patron: Patron;
    commentText: string;
    timeOfComment: Date;
}
