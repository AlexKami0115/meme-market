import { Card } from './card';
import { Patron } from './patron';
import { Timestamp } from 'rxjs';

export class Comment {
    id: number;
    cardId: number;
    username: string;
    commentText: string;
    timeOfComment: Date;
}
