import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

// Interface used for sorting function below
interface DisplayOrderInterface { 
  displayOrder: number
}

// Function used to sort any item that has a "displayOrder" field
export function compareDisplayOrder<T extends DisplayOrderInterface> (item1: T, item2: T) {
  if ( item1.displayOrder < item2.displayOrder ) {
    return -1;
  } else {
    return 1
  }
}