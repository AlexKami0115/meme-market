export class UrlService {
  private static readonly MONOLITH_URL = 'http://localhost:8080/mememarket/';
  constructor() { }
  public getUrl(): string {
    return UrlService.MONOLITH_URL;
  }
}
