import { Component, OnInit, Input } from '@angular/core';
import { Tag } from '../tag';
import { TagService } from '../services/tag.service';

@Component({
  selector: 'app-addcard',
  templateUrl: './addcard.component.html',
  styleUrls: ['./addcard.component.css']
})
export class AddcardComponent implements OnInit {
  @Input() tags: Tag[];

  constructor(
    private tagService: TagService
  ) { }

  ngOnInit(): void {
    this.tagService.getTags().subscribe(
      (data) => this.tags = data
    );
  }

}
