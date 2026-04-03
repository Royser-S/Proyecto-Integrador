import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { EquipmentService, Equipment } from '../../services/equipment.service';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-equipment-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, LucideAngularModule],
  templateUrl: './equipment-form.component.html',
  styleUrl: './equipment-form.component.css'
})
export class EquipmentFormComponent implements OnInit {
  equipment: Equipment = {
    nombre: '',
    codigo: '',
    ubicacion: '',
    estado: 'OPERATIVO',
    marca: '',
    modelo: ''
  };
  isEdit = false;

  constructor(
    private equipmentService: EquipmentService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.equipmentService.getById(+id).subscribe((data: Equipment) => {
        this.equipment = data;
      });
    }
  }

  onSubmit(): void {
    if (this.isEdit && this.equipment.id) {
      this.equipmentService.update(this.equipment.id, this.equipment).subscribe(() => {
        this.router.navigate(['/equipos']);
      });
    } else {
      this.equipmentService.create(this.equipment).subscribe(() => {
        this.router.navigate(['/equipos']);
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/equipos']);
  }
}
