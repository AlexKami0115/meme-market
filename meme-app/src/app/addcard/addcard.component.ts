import { Component, OnInit, Input } from '@angular/core';
import { Tag } from '../tag';
import { TagService } from '../services/tag.service';
import { Card } from '../card';
import { CardService } from '../services/card.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addcard',
  templateUrl: './addcard.component.html',
  styleUrls: ['./addcard.component.css']
})
export class AddcardComponent implements OnInit {
  public card: Card;
  public tags: Tag[];

  constructor(
    private cardService: CardService,
    private tagService: TagService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.tagService.getTags().subscribe(
      (data) => this.tags = data
    );
  }

  submit(): void {
    this.cardService.addCard(this.card).subscribe(
      card => {
        this.card = card;
        // this.router.navigate([])
      }
    )
  }

}
