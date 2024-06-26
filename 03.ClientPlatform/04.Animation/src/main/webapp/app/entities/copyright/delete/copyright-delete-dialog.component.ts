import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { ICopyright } from '../copyright.model';
import { CopyrightService } from '../service/copyright.service';

@Component({
  standalone: true,
  templateUrl: './copyright-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class CopyrightDeleteDialogComponent {
  copyright?: ICopyright;

  constructor(
    protected copyrightService: CopyrightService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.copyrightService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}
