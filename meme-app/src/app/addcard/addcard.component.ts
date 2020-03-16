import { Component, OnInit, Input } from '@angular/core';
import { Tag } from '../tag';
import { TagService } from '../services/tag.service';
import { Card } from '../card';
import { CardService } from '../services/card.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Rarity } from '../rarity';
import { RarityService } from '../services/rarity.service';

@Component({
  selector: 'app-addcard',
  templateUrl: './addcard.component.html',
  styleUrls: ['./addcard.component.css']
})
export class AddcardComponent implements OnInit {
  public card: Card;
  public tags: Tag[];
  public rarities: Rarity[];

  constructor(
    private cardService: CardService,
    private tagService: TagService,
    private rarityService: RarityService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.card = new Card;
    this.tagService.getTags().subscribe(
      (data) => this.tags = data
    );
    this.rarityService.getRarities().subscribe(
      (data) => this.rarities = data
    );
    
  }

  submit(): void {
    if (this.card.cardText && this.card.image && this.card.memeText) {
      this.cardService.addCard(this.card).subscribe(
        resp => {
          this.card = resp;
          alert('Card successfully created!');
          this.router.navigate(['/admin']);
        },
        error => {
          alert('Card not created.');
        }
      );
    } else {
      alert('Please fill out all fields.');
    }
    
  }

}
