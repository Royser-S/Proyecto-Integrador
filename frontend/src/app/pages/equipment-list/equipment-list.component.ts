import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { EquipmentService, Equipment } from '../../services/equipment.service';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-equipment-list',
  standalone: true,
  imports: [CommonModule, RouterModule, LucideAngularModule],
  templateUrl: './equipment-list.component.html',
  styleUrl: './equipment-list.component.css'
})
export class EquipmentListComponent implements OnInit {
  equipments: Equipment[] = [];
  loading = true;

  constructor(private equipmentService: EquipmentService) {}

  ngOnInit(): void {
    this.loadEquipments();
  }

  loadEquipments(): void {
    this.equipmentService.getAll().subscribe({
      next: (data: Equipment[]) => {
        this.equipments = data;
        this.loading = false;
      },
      error: () => this.loading = false
    });
  }

  deleteEquipment(id: number): void {
    if (confirm('¿Estás seguro de eliminar este equipo?')) {
      this.equipmentService.delete(id).subscribe(() => {
        this.loadEquipments();
      });
    }
  }

  getStatusClass(estado: string): string {
    switch (estado) {
      case 'OPERATIVO': return 'status-operative';
      case 'MANTENIMIENTO': return 'status-maintenance';
      case 'FUERA_SERVICIO': return 'status-failure';
      default: return '';
    }
  }
}
