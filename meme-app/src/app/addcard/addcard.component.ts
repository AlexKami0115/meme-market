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
  public tags: String;
  public rarities: Rarity[];

  constructor(
    private cardService: CardService,
    private tagService: TagService,
    private rarityService: RarityService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.card = new Card;
    this.rarityService.getRarities().subscribe(
      (data) => {
        this.rarities = data;
        this.card.rarity = this.rarities[0];
      }
    );
  }

  addRarity(id: String): void {
    this.card.rarity = this.rarities[Number(id)-1];
  }

  submit(): void {
    // Only try to add cards if required info is set
    if (this.card.cardText && this.card.image && this.card.memeText && this.card.rarity) {
      // Add all tags to the card
      this.card.tag = [];
      let tagArr = this.tags.split(" ");
      for (let t of tagArr) {
        let tag = new Tag();
        tag.name = t;
        this.card.tag.push(tag);
      }
      // Send card to backend to be added
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
