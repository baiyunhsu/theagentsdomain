import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import SharedModule from 'app/shared/shared.module';

@Component({
  selector: 'jhi-waiting-screen',
  standalone: true,
  imports: [SharedModule, RouterModule],
  templateUrl: './waiting-screen.component.html',
  styleUrl: './waiting-screen.component.scss'
})
export class WaitingScreenComponent {
  constructor(
    public router: Router
    ){
      
    }
  continue() {
    this.router.navigate(['/RenderingVideo']);
  }

}
