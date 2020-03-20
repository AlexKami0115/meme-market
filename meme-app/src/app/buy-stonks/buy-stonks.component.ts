import { Component, OnInit } from '@angular/core';
import { UrlService } from '../services/url.service';

@Component({
  selector: 'app-buy-stonks',
  templateUrl: './buy-stonks.component.html',
  styleUrls: ['./buy-stonks.component.css']
})
export class BuyStonksComponent implements OnInit {
  private appUrl = this.urlService.getUrl() + 'user';

  constructor(
    public urlService: UrlService
  ) { }

  ngOnInit(): void {
  }

  

}
