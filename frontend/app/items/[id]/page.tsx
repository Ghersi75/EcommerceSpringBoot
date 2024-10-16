"use client"

import { useState, useEffect } from "react"

export default function ViewItem({ params }: { params: { id: number } }) {
  

  return (
    <div>
      {params.id}
    </div>
  )
}