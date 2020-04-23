import { Component, OnInit } from '@angular/core';
import { LinkService } from './link.service';
import { Link } from './link';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public searchText:string;
  public links: Link [] = new Array<Link>();

  displayedColumns: string[] = ['url'];
  dataSource = this.links;
  constructor(private linkService:LinkService){

  }

  ngOnInit(): void {
    this.links= [
      {
        id:1,
        type:"intern",
        url:"https://www.google.com",
        domain:{
          id:1,
          name:"www.google.com"
        }     
      },
      {
        id:1,
        type:"extern",
        url:"https://www.youtube.com",
        domain:{
          id:1,
          name:"www.youtube.com"
        }     
      },
      {
        id:1,
        type:"intern",
        url:"https://www.netflix.com",
        domain:{
          id:1,
          name:"www.netflix.com"
        }     
      }
      

    ]
    this.dataSource=this.links;
   
  }

  public getLinks(searchText:string){
    this.linkService.getLinks(searchText).subscribe((data) =>{
      console.log(data);
      this.links=data;
      this.dataSource=data;

    });

  }

}
