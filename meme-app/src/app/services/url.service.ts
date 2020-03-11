export class UrlService {
  private static readonly MONOLITH_URL = 'http://18.232.129.96:8080/mememarket/';
  constructor() { }
  public getUrl(): string {
    return UrlService.MONOLITH_URL;
  }
}
